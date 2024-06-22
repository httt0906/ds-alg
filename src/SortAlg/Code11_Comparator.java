package SortAlg;

import java.util.Arrays;
import java.util.Comparator;

public class Code11_Comparator {
    public static class Student {
		public String name;
		public int id;
		public int age;

		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}

    public static class IdAscendingComparator implements Comparator<Student> {

        // 返回值是负数 第一个参数排在前面
        // 返回值是正数 第二个参数排在前面
        // 返回值是零(0) 无所谓谁排在前面
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;            
        } 
    }
    
}