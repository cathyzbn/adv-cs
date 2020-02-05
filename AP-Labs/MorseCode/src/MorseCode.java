/**
 * Encodes messages in Morse code using a map and
 * decodes messages using a "decoding tree" in the
 * Morse Code program.
 */
 
import java.util.TreeMap;

public class MorseCode
{
  private static final char DOT = '.';
  private static final char DASH = '-';

  private static TreeMap<Character, String> codeMap;
  private static TreeNode decodeTree;
  
  private static String strs(TreeNode root) {
      if (root == null) return "";
      else return strs(root.getLeft()) + root.getValue() + strs(root.getRight());
  }
  
  public static void start()
  {
    codeMap = new TreeMap<Character, String>();
    decodeTree = new TreeNode(' ', null, null);  // autoboxing
          // put a space in the root of the decoding tree

    addSymbol('A', ".-");
    addSymbol('B', "-...");
    addSymbol('C', "-.-.");
    addSymbol('D', "-..");
    addSymbol('E', ".");
    addSymbol('F', "..-.");
    addSymbol('G', "--.");
    addSymbol('H', "....");
    addSymbol('I', "..");
    addSymbol('J', ".---");
    addSymbol('K', "-.-");
    addSymbol('L', ".-..");
    addSymbol('M', "--");
    addSymbol('N', "-.");
    addSymbol('O', "---");
    addSymbol('P', ".--.");
    addSymbol('Q', "--.-");
    addSymbol('R', ".-.");
    addSymbol('S', "...");
    addSymbol('T', "-");
    addSymbol('U', "..-");
    addSymbol('V', "...-");
    addSymbol('W', ".--");
    addSymbol('X', "-..-");
    addSymbol('Y', "-.--");
    addSymbol('Z', "--..");
    addSymbol('0', "-----");
    addSymbol('1', ".----");
    addSymbol('2', "..---");
    addSymbol('3', "...--");
    addSymbol('4', "....-");
    addSymbol('5', ".....");
    addSymbol('6', "-....");
    addSymbol('7', "--...");
    addSymbol('8', "---..");
    addSymbol('9', "----.");
    addSymbol('.', ".-.-.-");
    addSymbol(',', "--..--");
    addSymbol('?', "..--..");
    
  }

  private static void addSymbol(char letter, String code)
  {
    treeInsert(letter, code);
    codeMap.put(letter, code);
  }

  private static void treeInsert(char letter, String code)
  {
    TreeNode current = decodeTree;
    char[] code_array = code.toCharArray();
    for (char c : code_array) {
        if (c == DOT) {
            if (current.getLeft() == null) current.setLeft(new TreeNode(" ", null, null));
            current = current.getLeft();
        }
        else if (c == DASH) {
            if (current.getRight() == null) current.setRight(new TreeNode(" ", null, null));
            current = current.getRight();
        }
    }
    current.setValue(letter);
    
  }

  public static String encode(String text)
  {
    StringBuffer morse = new StringBuffer(400);
    char[] chars = text.toUpperCase().toCharArray();
    for (char c : chars) {
        if (c == ' ') morse.append(" ");
        else morse.append(codeMap.get(c) + " ");
    }
    return morse.toString();
  }

  public static String decode(String morse)
  {
    StringBuffer text = new StringBuffer(100);
    String[] splited = morse.split(" ");
    for (String s : splited) {
        if(s.equals(" ")) text.append(s);
        else {
            char[] chars = s.toCharArray();
            TreeNode current = decodeTree;
            for (char c : chars) {
                if (c == DOT) current = current.getLeft();
                else if (c == DASH) current = current.getRight();
            }
            text.append(current.getValue());
        }
    }
    return text.toString();
  }
  
  public static void main(String[] args) {
    MorseCode.start();
  }
}
