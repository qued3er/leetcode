package _89;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @Title:
 * @Description:
 * @date 2020/8/99:03
 */
//1.一条路径 多个单词=isend
/*需要注意的几个点：
* 1.可能会有 某个单词以及它的前缀同时出现[所以需要isEnd字段来标明某个单词的前缀是否也在该前缀树中]
* 2.在找的时候，找的是某个单词的前缀 需要isEnd判断该单词是否真的存在
* 3.默认新生成节点的isEnd为false，在插入是 对最后一个节点的isEnd置为true。[不管是new的节点 还是原来已经有的别的单词的前缀]
* 由于startwith与search的代码几乎相同  对代码进行了重构。==》使得代码更清晰。*/
class TireNode{
        //如何实现中文版本的字典树？==》把数组改为使用ArrayList，其中当TireNode的引用。char 改为String。
        int number;
        boolean isEnd;
        TireNode []child;
        //加一层hash 可以增大前缀树可存储的字符范围
        char val;
        TireNode(){
                child=new TireNode[26];
        }
//        TireNode(int childrenNumber)
}
public class Trie {
        List<String> res=new ArrayList<>();
        TireNode head;
        public Trie() {
              head=new TireNode();
              head.isEnd=false;
        }

        public void insert(String word) {
                TireNode cur=head;
                char[] target = word.toCharArray();
                //先插入app再插入apple后边apple会把app的isEnd覆盖
                for (int i=0;i<target.length;i++){
                        int index=target[i]-'a';
                        if (cur.child[index]==null){
                                cur.child[index]=new TireNode();
                                //very important===》这样所有的结束节点的isEnd就都为false了  所以isEnd仅仅是用来标注是否是
                                //某个前缀结束点。
//                                cur.child[index].isEnd = false;
                                cur.child[index].val=target[i];
                        }
                        cur=cur.child[index];
                }
                cur.isEnd=true;
        }

        public boolean search(String word) {
                /*TireNode cur=head;
                char[] target = word.toCharArray();
                //找的仅是不一样的 忽略了前缀
                for (int i=0;i<target.length;i++){
                        int index=target[i]-'a';
                        if (cur.child[index]==null){
                                return false;
                        }
                        cur=cur.child[index];
                }*/
                TireNode node = findNode(word);
                if (node!=null&&node.isEnd){
                        return true;
                }
                return false;
//                if (node==null){
//                        return false;
//                }else {
//                        if (node.isEnd) {
//                                return true;
//                        } else {
//                                return false;
//                        }
//                }
        }

        public boolean startsWith(String prefix) {
                /*TireNode cur=head;
                char[] target = prefix.toCharArray();
                for (int i=0;i<target.length;i++){
                        int index=target[i]-'a';
                        if (cur.child[index]==null){
                                return false;
                        }
                        cur=cur.child[index];
                }*/
                TireNode node = findNode(prefix);
                if (node==null){
                        return false;
                }
//                if (cur.isEnd){
//                        return false;
//                }else {
//                        return true;
//                }
                return true;
        }
        //使用回溯法找以某个单词为前缀的所有的单词以单词的首字母排序,现在
        public List<String> findAllWordStartWith(String prefix){
                if (!startsWith(prefix)){
                        return null;
                }
                TireNode node = findNode(prefix);
                StringBuilder track=new StringBuilder();
                //证明有可以找
                backtrack(node,track,prefix);
                return res;
        }

        private void backtrack(TireNode node, StringBuilder track,String prefix) {
                if (node.isEnd){
                        res.add(prefix+track.toString());
                }
//                if (node==null){
//                        return;
//                }
                for(int i=0;i<node.child.length;i++){
                        if (node.child[i]!=null){
                                track.append(node.child[i].val);
                                backtrack(node.child[i],track,prefix);
                                track.deleteCharAt(track.length()-1);
                        }
                }
        }

        //找到的是前缀指针指向的树，需要在这儿加入把前缀返回
        public TireNode findNode(String word){
                TireNode cur=head;
                char[] target = word.toCharArray();
                //找的仅是不一样的 忽略了前缀
                for (int i=0;i<target.length;i++){
                        int index=target[i]-'a';
                        if (cur.child[index]==null){
                                return null;
                        }
                        cur=cur.child[index];
                }
                return cur;
        }
        public static void main(String[] args) {
                Trie trie = new Trie();

//                trie.insert("app");
                trie.insert("apple");   // 返回 true
//                trie.search("app");     // 返回 false
                trie.insert("appxx");
                trie.insert("appdd");
                trie.insert("a");
                trie.insert("death");
                trie.insert("dada");
                trie.insert("dadc");
                trie.insert("dadb");
                trie.insert("do");
                trie.insert("dry");
                trie.findAllWordStartWith("d");

        }
}

