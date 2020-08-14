package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Problem127 {

    public static void main(String[] args) {
        Problem127 p = new Problem127();

        long start = Calendar.getInstance().getTimeInMillis();
        List<String> list = Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob");
        System.out.println(p.ladderLength("cet", "ism", list));
        System.out.println(Calendar.getInstance().getTimeInMillis() - start);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }

        boolean find = false;
        for (String word: wordList) {
            if (endWord.equals(word)) {
                find = true;
            }
        }

        if (!find) {
            return 0;
        }

        int result = 1;

        boolean[][] arr = init(beginWord, endWord, wordList);
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> resultS = new LinkedList<>();
        Set<Integer> set = new HashSet<>(wordList.size());
        stack.add(0);
        set.add(0);
        resultS.add(1);

        while (!stack.isEmpty()) {
            result = resultS.pollFirst()+1;
            int from = stack.pollFirst();


            if (arr[from][arr.length - 1]) {
                return result;
            }

            for (int i = 0; i < arr.length; i++) {

                if (arr[from][i] && !set.contains(i)) {

                    stack.add(i);
                    set.add(i);
                    resultS.add(result);
                }
            }
        }

        return 0;
    }


    public boolean[][] init(String beginWord, String endWord, List<String> wordList) {

        List<String> t = new ArrayList<>(wordList.size() + 2);
        t.add(beginWord);
        t.addAll(wordList);
        t.add(endWord);

        boolean[][] arr = new boolean[t.size()][t.size()];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (canTran(t.get(i), t.get(j))) {
                    arr[i][j] = true;
                    arr[j][i] = true;
                }
            }
        }

        return arr;
    }

    public boolean canTran(String f, String s) {
        if (s.length() != f.length()) {
            return false;
        }

        int d = 0;
        char[] fs = f.toCharArray();
        char[] ss = s.toCharArray();
        for (int i = 0; i < fs.length; i++) {

            if (fs[i] != ss[i]) {

                d++;
                if (d > 1) {
                    return false;
                }
            }
        }
        if (d == 1) {
            return true;
        }

        return false;
    }
}
