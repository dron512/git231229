package ch14;

import java.util.*;
import java.util.stream.*;

class StreamEx1 {
	public static void main(String[] args) {
	     Stream<Student> studentStream = Stream.of(
							new Student("���ڹ�", 3, 300),
							new Student("���ڹ�", 1, 200),
							new Student("���ڹ�", 2, 100),
							new Student("���ڹ�", 2, 150),
							new Student("���ڹ�", 1, 200),
							new Student("���ڹ�", 3, 290),
							new Student("���ڹ�", 3, 180)
						);

	     studentStream.sorted(Comparator.comparing(Student::getBan) // �ݺ� ����
			    	  .thenComparing(Comparator.naturalOrder()))    // �⺻ ����
					  .forEach(System.out::println);
	}
}

//class Student implements Comparable<Student> {
//	String name;
//	int ban;
//	int totalScore;
//
//	Student(String name, int ban, int totalScore) { 
//		this.name =name;
//		this.ban =ban;
//		this.totalScore =totalScore;
//	}
//
//	public String toString() { 
//	    return String.format("[%s, %d, %d]", name, ban, totalScore).toString(); 
//	}
//
//	String getName()     { return name;}
//	int getBan()         { return ban;}
//	int getTotalScore()  { return totalScore;}
//
//   // ���� ���������� �⺻ ���ķ� �Ѵ�.
//	public int compareTo(Student s) { 
//		return s.totalScore - this.totalScore;
//	}
//}
