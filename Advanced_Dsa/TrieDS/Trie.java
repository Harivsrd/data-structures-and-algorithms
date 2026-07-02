import java.util.Scanner;

class TrieNode {
    TrieNode children[];
    boolean isLeaf;
    int searchCount = 0;
    int prefixCount = 0;

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    void insert(String key) {
        TrieNode curr = root;
        for(char c : key.toCharArray()) {
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.prefixCount++;
        }
        curr.isLeaf = true;
        curr.searchCount++;
    }

    boolean search(String key) {
        TrieNode curr = root;
        for(char c : key.toCharArray()) {
            if(curr.children[c-'a']==null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isLeaf;        
    }

    boolean isPrefix(String key){
        TrieNode curr = root;
        for(char c : key.toCharArray()) {
            if(curr.children[c-'a']==null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;         
    }

    int searchCount(String key){
        TrieNode curr = root;
        for(char c : key.toCharArray()) {
            if(curr.children[c-'a']==null) {
                return 0;
            }
            curr = curr.children[c-'a'];
        }
        return curr.searchCount;         
    }

        int prefixCount(String key){
        TrieNode curr = root;
        for(char c : key.toCharArray()) {
            if(curr.children[c-'a']==null) {
                return 0;
            }
            curr = curr.children[c-'a'];
        }
        return curr.prefixCount;         
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        int choice;
        String word;

        do {
            System.out.println("\n--- Trie Menu ---");
            System.out.println("1. Insert word");
            System.out.println("2. Search word");
            System.out.println("3. Check prefix");
            System.out.println("4. Search count of word");
            System.out.println("5. Prefix count");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter word to insert: ");
                    word = sc.nextLine();
                    trie.insert(word);
                    System.out.println("Inserted: " + word);
                    break;
                case 2:
                    System.out.print("Enter word to search: ");
                    word = sc.nextLine();
                    System.out.println(trie.search(word) ? "Found" : "Not Found");
                    break;
                case 3:
                    System.out.print("Enter prefix to check: ");
                    word = sc.nextLine();
                    System.out.println(trie.isPrefix(word) ? "Prefix exists" : "Prefix not found");
                    break;
                case 4:
                    System.out.print("Enter word to get search count: ");
                    word = sc.nextLine();
                    System.out.println("Search count = " + trie.searchCount(word));
                    break;
                case 5:
                    System.out.print("Enter prefix to get count: ");
                    word = sc.nextLine();
                    System.out.println("Prefix count = " + trie.prefixCount(word));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 6);

        sc.close();
    }
}