USE `spring`;
--
-- Table structure for table `user`
--
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `emailid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_books`
--
CREATE TABLE `user_books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(255) DEFAULT NULL,
  `book_author` varchar(255) DEFAULT NULL,
  `book_category` varchar(255) DEFAULT NULL,
  `book_owner` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
