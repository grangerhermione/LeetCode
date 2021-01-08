package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * https://leetcode.com/problems/design-in-memory-file-system/
 * 
 * Design In-Memory File System:
Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this 
file's name. If it is a directory path, return the list of file and directory names in this directory. 
Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the 
path. If the middle directories in the path don't exist either, you should create them as well. 
This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, 
you need to create that file containing given content. If the file already exists, 
you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.
 */
public class DesignInMemoryFileSystem {
	class File {
		boolean isfile = false;
		HashMap < String, File > files = new HashMap < > ();
		String content = "";
	}
	File root;
	public DesignInMemoryFileSystem() {
		root = new File();
	}

	public List<String> ls(String path) {
		File t = root;
		List < String > files = new ArrayList < > ();
		if (!path.equals("/")) {
			String[] d = path.split("/");
			for (int i = 1; i < d.length; i++) {
				t = t.files.get(d[i]);
			}
			if (t.isfile) {
				files.add(d[d.length - 1]);
				return files;
			}
		}
		List < String > res_files = new ArrayList < > (t.files.keySet());
		Collections.sort(res_files);
		return res_files;
	}

	public void mkdir(String path) {
		File t = root;
		String[] d = path.split("/");
		for (int i = 1; i < d.length; i++) {
			if (!t.files.containsKey(d[i]))
				t.files.put(d[i], new File());
			t = t.files.get(d[i]);
		}
	}

	public void addContentToFile(String filePath, String content) {
		File t = root;
		String[] d = filePath.split("/");
		for (int i = 1; i < d.length - 1; i++) {
			t = t.files.get(d[i]);
		}
		if (!t.files.containsKey(d[d.length - 1]))
			t.files.put(d[d.length - 1], new File());
		t = t.files.get(d[d.length - 1]);
		t.isfile = true;
		t.content = t.content + content;
	}

	public String readContentFromFile(String filePath) {
		File t = root;
		String[] d = filePath.split("/");
		for (int i = 1; i < d.length - 1; i++) {
			t = t.files.get(d[i]);
		}
		return t.files.get(d[d.length - 1]).content;
	}
}
