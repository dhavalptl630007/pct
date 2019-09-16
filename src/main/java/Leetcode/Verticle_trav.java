package Leetcode;

//top view of tree can be found by vertical and order traversal of tree
// Next time : no need to create map for level and vertical traversal, just store the result in list

// refer https://youtu.be/c3SAvcjWb1E

// input : 1 2 5 3 6 4
//output : 1 2 5 6 
  
// input 1 14 3 7 4 5 15 6 13 10 11 2 12 8 9
// output 2 1 14 15 12 
// input : 13 105 278 16 60 135 47 129 234 372 271 179 189 103 302 71 377 4 112 195 360 151 348 125 393 351 236 409 68 371 210 149 255 37 24 259 243 10 91 98 126 160 308 229 297 107 95 353 175 172 191 163 379 137 386 49 67 405 257 110 199 15 327 416 184 22 38 148 383 374 200 138 263 158 339 19 132 50 79 370 401 230 34 190 48 176 41 162 346 28 64 202 414 222 161 334 76 127 244 306 96 399 177 88 239 33 73 356 344 3 45 58 219 311 332 231 156 284 204 106 178 59 44 194 237 226 354 247 99 335 304 186 410 266 114 185 81 341 92 113 375 368 55 256 396 78 218 281 197 7 72 143 395 277 46 358 282 382 142 187 251 310 290 285 57 328 292 352 317 180 82 323 364 89 260 128 119 217 100 153 397 388 164 173 345 8 43 343 196 155 307 331 117 144 301 26 272 340 324 134 240 120 337 77 391 407 201 168 250 312 17 289 53 35 5 303 14 270 192 108 208 369 390 253 147 299 305 213 400 363 373 181 295 261 309 145 298 205 408 349 29 269 152 367 413 279 238 62 102 116 392 40 51 254 140 74 227 165 330 27 63 315 54 258 85 12 104 357 118 241 31 193 198 122 130 183 361 274 291 25 146 121 321 268 273 36 316 216 70 171 75 380 296 66 264 398 359 87 338 355 220 288 225 21 94 157 207 86 97 235 83 381 221 61 42 111 150 320 188 123 300 215 329 267 170 18 167 224 265 293 23 124 212 39 376 326 378 169 415 65 365 394 245 182 211 242 350 336 385 342 233 84 283 228 154 166 418 206 389 214 133 347 232 275 52 402 287 2 318 93 280 248 313 1 131 209 412 406 249 325 276 6 286 9 333 403 314 262 387 30 56 362 141 11 109 417 136 139 322 223 246 101 80 294 404 319 32 69 20 115 174 366 252 90 384 159 411 203
// output : 17 1 2 3 4 13 105 278 372 377 393 409 416 418 

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class TreeNode
{
	int data;
	TreeNode left;
	TreeNode right;
	int dist;
	TreeNode(int arr,int dist)
	{
		this.data = arr;
		this.left = null;
		this.right = null;
		this.dist = dist;
		
	}
	
}


public class Verticle_trav {

 private static TreeMap<Integer,ArrayList<Integer>>map = new TreeMap<Integer,ArrayList<Integer>>();
 private static LinkedHashMap<Integer,ArrayList<Integer>>maplevel = new LinkedHashMap<Integer,ArrayList<Integer>>();
 private static ArrayList<Integer> levelorder = new  ArrayList<Integer>();
 private static ArrayList<Integer> verticalorder = new  ArrayList<Integer>();
 //private static ArrayList<Integer> list = new ArrayList<Integer>();
private static int root_level = 0;
 
 public static void main (String [] args)
 {
	Scanner sc = new Scanner(System.in); 

	//int v = Integer.parseInt(sc.nextLine());
	
    String arr[] = sc.nextLine().split("\\s+");
      
    TreeNode root = new TreeNode(Integer.parseInt(arr[0]),0);
   
    for (int i =1; i<arr.length;i++)
    {
    createtree(root,Integer.parseInt(arr[i]),0); 	
    	
    } 
    
    preorderTraversal(root);
    verticalTraversal();
    //System.out.print(map);
    
    int h = heightofTree(root);
   // System.out.println(h);
    
    for (int i = 0; i <=h; i++)
    {
      root_level = i+1;	
      ArrayList<Integer> list = new ArrayList<Integer>();
    levelTraversal(root,1 + i,list);
	 
    }
    
 

   
// System.out.println(map);
//System.out.println(maplevel);
//System.out.println(levelorder);
//System.out.println(verticalorder);
    
    Topview();
 }

private static void Topview() {
	
	for (Entry<Integer,ArrayList<Integer>> entry :  map.entrySet())
	{
		  ArrayList<Integer> list = entry.getValue();
		  int len = list.size();
		  if (len==1)
		  {
			  System.out.print(list.get(0)+" ");
		  }
		  else
		  {
			 int element= checkInlevelorder(list);
			 //select the elemenT which comes first in leveltraversal
			 System.out.print(element+" ");
		  }
	}
	
}

private static int checkInlevelorder(ArrayList<Integer> list) {
	
  int min = levelorder.size();
  int element = 0;
	
	for (int temp : list)
	{
	  int pos = levelorder.indexOf(temp);
	  
	  if (pos < min)
	  {
		  min = pos;
		  element = temp;
	  }
		
	}
	
	return element;
	
}

private static void levelTraversal(TreeNode root, int level,ArrayList<Integer> list) {
	
	if (root ==null)
	{
		return;
	}
	
	if (level ==1)
	{
		if (maplevel.containsKey(root_level))
		{
		   maplevel.get(root_level).add(root.data);
	      		
		}
		else
		{
			list.add(root.data);
			maplevel.put(root_level,list);
		  	
		}
		
		levelorder.add(root.data);
	}
	
	else if (level >1)
	{
		levelTraversal(root.left,  level-1,list);
		levelTraversal(root.right,  level-1,list);
		
	}
	
}

private static int heightofTree(TreeNode root) {
    
	if (root == null)
	{
		return -1;
	}
	
	
	return  1 + Math.max(heightofTree(root.left),heightofTree(root.right));
}

private static void verticalTraversal() {
	//System.out.println("---Vertical order--");
	for(Entry <Integer,ArrayList<Integer>> entry : map.entrySet())
	{
		for (int temp : entry.getValue())
		{
			verticalorder.add(temp);
		}
		
	}
	
	
}

private static void preorderTraversal(TreeNode root) {
	
	if(root == null)
	{
		return;
	}
	
	//System.out.println(root.data + " "+root.dist);
	
	if(map.containsKey(root.dist))
	{
	  map.get(root.dist).add(root.data);
	}
	else
	{
	 ArrayList<Integer>	list = new ArrayList<Integer>();
	 list.add(root.data);
	 map.put(root.dist,list);
	 
    
	}
	preorderTraversal(root.left);
	preorderTraversal(root.right);
	
}

private static void createtree(TreeNode root,int data,int dist) {
	
  if(root == null)
  {
     return;
  }
  
   if (root.left == null && (data <root.data))
   {
	   root.left = new TreeNode(data,dist-1);
	   return;
   }
  
    if (root.right == null && (data > root.data))
    {
    	
    	root.right = new TreeNode(data,dist+1);
    	return;
    }
  
    if (data <root.data)
    {
       createtree(root.left,data,dist-1);	
    }
    else if (data > root.data)
    {
    	 createtree(root.right,data,dist+1);	
    }
       
}
	
}
