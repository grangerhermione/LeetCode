package strings;

/*
 * https://leetcode.com/problems/read-n-characters-given-read4/
 * 
 * Read N Characters Given Read4:
 * Given a file and assume that you can only read the file using a given method read4, 
 * implement a method to read n characters.
 */

public class ReadNCharactersGivenRead4 extends Reader4{
	public int read(char[] buf, int n) {
        int limit=n;
        int k=0;
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
        }
        else{
             for(int i=0;i<r;i++){
                buf[k++]=buffer[i];
            }
        }
        return k;
        
    }
}

class Reader4{
	int read4(char[] buf) {
		return 0;
	}
}
