package NeedCode;

import java.util.List;
import java.util.stream.Collectors;

public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("CHLOROHYDROTHIAZIDE", "HYDROCHLOROTHIAZIDE"));
	}

	public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        List <Character> list = s.chars()
                                    .mapToObj(c -> (char) c)
                                    .collect(Collectors.toList());

        char [] array = t.toCharArray();
        for(int i = 0 ; i < array.length ; i++){
            Character temp = array[i];
            list.remove(temp);
        }
        return (list.size() == 0);
    }
}
