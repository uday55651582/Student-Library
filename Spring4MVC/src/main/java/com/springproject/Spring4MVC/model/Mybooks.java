package com.springproject.Spring4MVC.model;

import javax.persistence.*;

import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Indexed
@Entity
@Table(name = "user_books")
public class Mybooks {
	
	    private Long book_id;
	    

	    @Column(name = "title", nullable= false, length = 128)
	    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	    private String book_title;
	    
	    @Column(name = "title", nullable= false, length = 128)
	    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	    private String book_author;
	    

	    @Column(name = "title", nullable= false, length = 128)
	    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	    private String book_category;
	    
	    private String book_owner;

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)

		public Long getBook_id() {
			return book_id;
		}

		public void setBook_id(Long book_id) {
			this.book_id = book_id;
		}


		public String getBook_title() {
			return book_title;
		}

		public void setBook_title(String book_title) {
			this.book_title = book_title;
		}

		public String getBook_author() {
			return book_author;
		}

		public void setBook_author(String book_author) {
			this.book_author = book_author;
		}

		public String getBook_category() {
			return book_category;
		}

		public void setBook_category(String book_category) {
			this.book_category = book_category;
		}

		public String getBook_owner() {
			return book_owner;
		}

		public void setBook_owner(String book_owner) {
			this.book_owner = book_owner;
		}

	
		

}
