import java.util.ArrayList;
import java.util.List;

/*
 * Given a file and assume that you can only read the file using a given method read4, 
 * implement a method to read n characters.
 * Your method read may be called multiple times.
 */
public class ReadNCharactersGivenRead4II extends Reader4 {
	List<Character> list=new ArrayList<>();
	public int read(char[] buf, int n) {
		int limit=n;
		int k=0;

		while(list.size()>0 && limit>0){
			buf[k++]=list.get(0);
			list.remove(0);
			limit--;
		}
		while(limit>=4){
			char[] buffer = new char[4]; 
			int r=read4(buffer);
			for(int i=0;i<r;i++){
				buf[k++]=buffer[i];
			}
			limit-=4;
		}
		if(limit<=0){
			return k;
		}

		char[] buffer = new char[4]; 
		int r=read4(buffer);
		if(r>=limit){
			for(int i=0;i<limit;i++){
				buf[k++]=buffer[i];
			}
			for(int i=limit;i<r;i++){
				list.add(buffer[i]);
			}
		}
		else{
			for(int i=0;i<r;i++){
				buf[k++]=buffer[i];
			}
		}

		return k;
	}
}
