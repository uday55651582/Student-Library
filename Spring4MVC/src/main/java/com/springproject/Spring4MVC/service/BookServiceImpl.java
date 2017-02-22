package com.springproject.Spring4MVC.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.springproject.Spring4MVC.model.Mybooks;
import com.springproject.Spring4MVC.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import javax.transaction.Transactional;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public BookServiceImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
   //@Override
    public void save(Mybooks mybooks) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 	     String currentPrincipalName = authentication.getName();
    	mybooks.setBook_owner(currentPrincipalName);
        bookRepository.save(mybooks);
      
    }


	public List<Mybooks> findAll() {
	
	    return bookRepository.findAll();

	}

	
	@Override
	public void update(Mybooks mybooks) {
		
	        String sql = "UPDATE user_books SET book_author=?, book_title=?, book_category=?, "
	                    + "book_owner=? WHERE book_id=?";
	        jdbcTemplate.update(sql, mybooks.getBook_id(),mybooks.getBook_title(),mybooks.getBook_author(),
	        		mybooks.getBook_category(),mybooks.getBook_owner());
		
	}


	@Override
	public void delete(int bookid) {
		 String sql = "DELETE FROM contact WHERE contact_id=?";
		    jdbcTemplate.update(sql, bookid);		
	}
	
	@Override
	public Mybooks getbook(int bookid) {
		System.out.println("getbooks...........");
		String sql = "SELECT * FROM book_users WHERE book_id=" + bookid;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Mybooks>(){
	    	 
	        @Override
	        public Mybooks extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Mybooks book = new Mybooks();
	                book.setBook_id((long) rs.getInt("book_id"));
	                book.setBook_author(rs.getString("book_author"));
	                book.setBook_title(rs.getString("book_title"));
	                book.setBook_owner(rs.getString("book_owner"));
	                book.setBook_category(rs.getString("book_category"));
	                return book;
	            }
	 
	            return null;
	        }
	        
	        });
	    }
	
	@Override
	public List<Mybooks> findbyowner(String emailid) {
		List<Mybooks>booklist=new ArrayList<Mybooks>();
			for(Mybooks x:bookRepository.findAll())
			{
				if(x.getBook_owner().equalsIgnoreCase(emailid))
				{
					booklist.add(x);
				}
			}
		
	return booklist;
	
	}
	
	@Transactional
	@Override
	public List<Mybooks> searchForBook(String searchText) throws Exception
	{
		System.out.println("search text............"+ searchText);
	      
	      String sql = "SELECT * FROM user_books WHERE book_title LIKE '"+searchText+"%' OR book_title LIKE '%" +searchText+"' OR book_title LIKE '%"+ searchText+"%' OR book_author LIKE '"+searchText+"%' OR book_author LIKE '%" +searchText+"' OR book_author LIKE '%"+ searchText+"%' OR book_category LIKE '"+searchText+"%' OR book_category LIKE '%" +searchText+"' OR book_category LIKE '%"+ searchText+"%'";
	      
	      
	         System.out.println("sql query is....."+ sql);
	      
	      List<Mybooks> listContact = jdbcTemplate.query(sql, new RowMapper<Mybooks>() {
	    	  
	          @Override
	          public Mybooks mapRow(ResultSet rs, int rowNum) throws SQLException {
	              Mybooks aContact = new Mybooks();
	   
	              aContact.setBook_author(rs.getString("book_author"));
	              aContact.setBook_title(rs.getString("book_title"));
	              aContact.setBook_category(rs.getString("book_category"));
	   
	              return aContact;
	          }
	   
	      });
	   
	      return listContact;
	}
	
}

	

