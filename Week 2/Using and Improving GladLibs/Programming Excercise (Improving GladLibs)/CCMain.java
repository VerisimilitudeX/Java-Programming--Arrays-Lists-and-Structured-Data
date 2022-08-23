public class CCMain {
    public static void main(String[] args) {
        CodonCount cc = new CodonCount();
        cc.buildCodonMap(0, "CGTTCAAGTTCAA");
        cc.printCodonCounts(1, 5);
    }
}
