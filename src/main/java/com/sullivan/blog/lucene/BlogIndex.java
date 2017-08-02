package com.sullivan.blog.lucene;

import com.sullivan.blog.entity.Blog;
import com.sullivan.blog.util.DateUtil;
import com.sullivan.blog.util.StringUtil;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 博客索引类
 * @author Sullivan
 *
 */
public class BlogIndex {

	private Directory dir;

	private IndexWriter getWriter() throws Exception {
		dir = FSDirectory.open(Paths.get("/data/blog_index"));
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(dir, config);
		return writer;
	}

	//添加博客索引
	public void addIndex(Blog blog)  throws Exception {
		IndexWriter writer = getWriter();
		Document doc = new Document();
		//Store.YES 保存 可以查询 可以打印内容
		//Store.NO 不保存 可以查询 不可打印内容 由于不保存内容所以节省空间
		//Store.COMPRESS 压缩保存 可以查询 可以打印内容 可以节省生成索引文件的空间
		doc.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
		doc.add(new TextField("title", blog.getTitle(), Field.Store.YES));
		doc.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"), Field.Store.YES));
		doc.add(new TextField("content", blog.getContentNoTag(), Field.Store.YES));
		writer.addDocument(doc);
		writer.close();
	}

	//删除指定博客的索引
	public void deleteIndex(String blogId) throws Exception {
		IndexWriter writer = getWriter();
		writer.deleteDocuments(new Term("id", blogId));//将id对应的文档，删除
		writer.forceMergeDeletes();//强制删除
		writer.commit();
		writer.close();
	}

	//更新博客索引
	public void updateIndex(Blog blog) throws Exception {
		IndexWriter writer = getWriter();
		Document doc = new Document();
		doc.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
		doc.add(new TextField("title", blog.getTitle(), Field.Store.YES));
		doc.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"), Field.Store.YES));
		doc.add(new TextField("content", blog.getContentNoTag(), Field.Store.YES));
		writer.updateDocument(new Term("id", String.valueOf(blog.getId())), doc);//将id对应的文档，用新建的文档替换
		writer.close();
	}

	//查询博客索引信息
	public List<Blog> searchBlog(String q) throws Exception {

		dir = FSDirectory.open(Paths.get("/data/blog_index"));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher search = new IndexSearcher(reader);
		//多条件查询
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
		//中文分词
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();

		//多关键字搜索
		QueryParser parser1 = new QueryParser("title", analyzer); //查询标题
		Query query1 = parser1.parse(q);

		QueryParser parser2 = new QueryParser("content", analyzer); //查询内容
		Query query2 = parser2.parse(q);

		//组合搜索 BooleanClause.Occur.SHOULD表示的是或的关系，表明当前加入的子句是可选的。
		booleanQuery.add(query1, BooleanClause.Occur.SHOULD);
		booleanQuery.add(query2, BooleanClause.Occur.SHOULD);

		TopDocs hits = search.search(booleanQuery.build(), 100);

		QueryScorer scorer = new QueryScorer(query1);//使用title得分高的排前面
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer); //得分高的片段
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer); //高亮显示
		highlighter.setTextFragmenter(fragmenter); //将得分高的片段设置进去

		List<Blog> blogIndexList = new LinkedList<Blog>(); //用来封装查询到的博客
		for(ScoreDoc score : hits.scoreDocs) {
			Document doc = search.doc(score.doc);
			Blog blog = new Blog();
			blog.setId(Integer.parseInt(doc.get("id")));
			blog.setReleaseDateStr(doc.get("releaseDate"));
			String title = doc.get("title");
			String content = doc.get("content");
			if(title != null) {
				TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
				String hTitle = highlighter.getBestFragment(tokenStream, title);
				if(StringUtil.isEmpty(hTitle)) {
					blog.setTitle(title);
				} else {
					blog.setTitle(hTitle);
				}
			}
			if(content != null) {
				TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(content));
				String hContent = highlighter.getBestFragment(tokenStream, content);
				if(StringUtil.isEmpty(hContent)) {
					if(content.length() > 100) { //如果没查到且content内容又大于100的话
						blog.setContent(content.substring(0, 100)); //截取100个字符
					} else {
						blog.setContent(content);
					}
				} else {
					blog.setContent(hContent);
				}
			}
			blogIndexList.add(blog);
		}

		return blogIndexList;
	}
}
