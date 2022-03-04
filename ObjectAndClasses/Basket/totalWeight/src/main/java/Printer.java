public class Printer {
    static String text;
    static String name;
    static int page;
    String queue;
    int hMPage = 0 ;
    int getPage = 0;

    public static void main(String[] args) {

    }
    public void append(String text, int page){
        this.text = text;
        this.page = page;
        queue = queue + "\n" + text + " - " + page + " страниц";
        hMPage = hMPage + page;
    }
    public void append(String text, String name){
        this.text = text;
        this.name = name;
        queue = queue + "\n" + name + " - " + text;
    }

    public int append(String text, int page, String name){
        this.text = text;
        this.page = page;
        this.name = name;
        hMPage = hMPage + page;
        queue = queue + "\n" + name + " - " + text + " - " + page + " страниц";
        return hMPage;
        }
    public void clean(){
        queue = "";
        }
    public int print(){
        System.out.println(queue);
        queue = "";
        getPage = getPage + hMPage;
        return hMPage = 0;
        }
    public int getPendingPagesCount(){
         return hMPage;
        }
    public int allPage(){
        return getPage;
        }

    }




