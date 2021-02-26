@SYS-291
Feature:

	Background:
		
				    Given the user logged in as a "librarian"
				    Given the user navigate to "Books" tab
				    Given the user click on Add Book button
		

	@SYS-286 @SYS-291
	Scenario: Librarian can add books with valid inputs
		
		    And the user add new book using following information
		      | Book Name     | War and Peace          |
		      | ISBN          | 123456789              |
		      | Year          | 1869                   |
		      | Author        | Leo Tolstoy            |
		      | Book Category | Historical Fiction     |
		      | Description   | Story of five families |
		
		    Then "The book has been created." message should be displayed	


	@SYS-287 @SYS-291
	Scenario Outline: Librarian cannot add books with invalid inputs
		
		    When the user enters "<Book Name>""<ISBN>""<Year>""<Author>""<Book Category>""<Description>" information
		    Then "The book has been created." message should not be displayed
		    Examples:
		      | Book Name     | ISBN              | Year | Author      | Book Category      | Description            |
		      | War and Peace | 123456789         | %7AB | Leo Tolstoy | Historical Fiction | Story of five families |
		      | War and Peace | 1#$78AB           | 2012 | Leo Tolstoy | Historical Fiction | Story of five families |
		      | War and Peace | 1234567890123-654 | 0012 | Leo Tolstoy | Historical Fiction | Story of five families |
			


	@SYS-288 @SYS-291
	Scenario Outline: Librarian cannot add books without inputs
		
		    When the user enters "<Book Name>""<ISBN>""<Year>""<Author>""<Book Category>""<Description>" information
		    Then "This field is required." message should be displayed under Book Name, Year or Author
		    Examples:
		      | Book Name     | ISBN      | Year | Author      | Book Category      | Description            |
		      |               | 123456789 | %7AB | Leo Tolstoy | Historical Fiction | Story of five families |
		      | War and Peace | 123456789 |      | Leo Tolstoy | Historical Fiction | Story of five families |
		      | War and Peace | 123456789 | 0012 |             | Historical Fiction | Story of five families |	


	@SYS-289 @SYS-291
	Scenario: Add book should have following parameters
		
		
		    And Add book should have following parameters
		      | Book Name     |
		      | ISBN          |
		      | Year          |
		      | Author        |
		      | Book Category |
		      | Description   |	


	@SYS-290 @SYS-291
	Scenario: Following categories should be present
		
		
		    And Following categories should be present
		      | Action and Adventure    |
		      | Anthology               |
		      | Classic                 |
		      | Comic and Graphic Novel |
		      | Crime and Detective     |
		      | Drama                   |
		      | Fable                   |
		      | Fairy Tale              |
		      | Fan-Fiction             |
		      | Fantasy                 |
		      | Historical Fiction      |
		      | Horror                  |
		      | Science Fiction         |
		      | Biography/Autobiography |
		      | Humor                   |
		      | Romance                 |
		      | Short Story             |
		      | Essay                   |
		      | Memoir                  |
		      | Poetry                  |