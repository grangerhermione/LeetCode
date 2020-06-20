package strings;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 * 
 * Read N Characters Given Read4 II - Call multiple times:
 * Given a file and assume that you can only read the file using a given method read4, 
 * implement a method to read n characters.
 * Your method read may be called multiple times.
 */
public class ReadNCharactersGivenRead4II extends Reader4 {
	LinkedList<Character> list=new LinkedList<>();
    public int read(char[] buf, int n) {
        int limit=n;
        int k=0;

        while(list.size()>0 && limit>0){
            buf[k++]=list.get(0);
            list.remove();
            limit--;
        }
        char[] buffer = new char[4]; 
        while(limit>=4){
            int r=read4(buffer);
            for(int i=0;i<r;i++){
                buf[k++]=buffer[i];
            }
            limit-=4;
        }
        if(limit<=0){
            return k;
        }
        
        int r=read4(buffer);
        int end=Math.min(r, limit);
        for(int i=0;i<end;i++){
            buf[k++]=buffer[i];
        }
        if(r>=limit){
            for(int i=limit;i<r;i++){
                list.add(buffer[i]);
            }
        }
        return k;
    }
}
