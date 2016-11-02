package com.ivan.androidfanny.ui;

import android.widget.TextView;

import com.ivan.androidfanny.R;
import com.ivan.androidfanny.base.BaseActivity;
import com.ivan.androidfanny.db.Author;
import com.ivan.androidfanny.db.Book;

import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/1.
 */

public class DbActivity extends BaseActivity {

    @Bind(R.id.tv_db_content)
    TextView tvDbContent;

    @Override
    protected void initDataAndView() {

    }

    @Override
    protected int getContentViewRes() {
        return R.layout.activity_db;
    }

    @OnClick(R.id.btn_db_query)
    void query() {
        List<Book> books = DataSupport.findAll(Book.class,true);
        if (books != null) {
            tvDbContent.setText(books.toString());
        }
    }

    @OnClick(R.id.btn_db_save)
    void save() {
        Book book = new Book();
        book.setName("Java编程思想");
        book.setPrice(42.5f);

        Author author = new Author();
        author.setName("张孝祥");
        author.setAge(45);
        author.setAddress("北京");

        author.save();

        book.setAuthor(author);

        book.save();
    }
}
