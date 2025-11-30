package exercicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.Comment;
import entities.Post;

public class Posts {

	public static void main(String[] args) {
		
		Comment c1 = new Comment("Have a nice trip");
		Comment c2 = new Comment("Wow, that's awesome");
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
		LocalDateTime moment = LocalDateTime.parse("21/06/2020 08:20:32", fmt1);
		
		Post p1 = new Post(moment,
				"Traveling to new Zealand",
				"Im going to visit this wonderful place",
				12);
		
		p1.addComment(c1);
		p1.addComment(c2);
		
		
		System.out.println(p1);
	}

}
