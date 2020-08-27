package _815;

import com.sun.xml.internal.ws.api.message.Header;
import sun.reflect.generics.tree.Tree;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/1512:14
 */
//设计一棵前缀树
class TreeNode{
   //长度为26的数组 TreeNode数组 0指向下一个为a的node  1指向下一个为b的node
    TreeNode [] next=new TreeNode[26];
    //当某个单词的前缀也出现的时候 两个单词会共用一条路径，所以需要isEnd来指示是否当前元素的前缀是否也在该前缀树中
    boolean isEnd;
    //指示当前子树的节点的个数
    int number;
    //当前字符
    char character;

}
public class WordDictionary {
    TreeNode head;
    boolean flag;
    /** Initialize your data structure here. */
    public WordDictionary() {
        head=new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] target = word.toCharArray();
        TreeNode cur=head;
        for (int i=0;i<target.length;i++){
            int index=target[i]-'a';
            if (cur.next[index]==null){
                TreeNode node=new TreeNode();
                node.character=target[i];
                cur.next[index]=node;
            }
            cur=cur.next[index];
        }
        cur.isEnd=true;
    }
    //查找时会遇到. ，.的意义就是遍历整棵子树  如果当前是.，则证明下一个想找的是任何一个next   也就是当前节点不为空的的next的节点
    //作为根节点。    只要有一个匹配的就匹配  ===》通过flag来早返回
    //没考虑第一个就为.的
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] target = word.toCharArray();
        return matching(target,0,head);
    }
    //给定一个节点作为根节点 去匹配start之后的东西
    private boolean matching(char[] target, int start, TreeNode head) {
        TreeNode cur =head;
        for (int i = start; i <target.length; i++) {
            //1个可均可 所以应该设置一个flag 当有一个可以了就不再继续
            if (target[i]=='.'){
                //所有不为空的孩子都可以做根
                //a.如果没有一个匹配的就不匹配
                for (int j=0;j<cur.next.length;j++) {
                    //一个为真就有匹配
                    if (flag){
                        //更新flag  因为是全局变量
                        flag=false;
                        return true;
                    }
                    if (cur.next[j]!=null)
                        if (matching(target, i + 1,cur.next[j] )){
                            flag=true;
                        }
                }
                if (!flag){
                    return flag;
                }
            }else {
                int index=target[i]-'a';
                if (cur.next[index]==null){
                    return false;
                }
                cur=cur.next[index];
            }
        }
        if (cur.isEnd){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary=new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }
}
