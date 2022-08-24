import java.util.HashMap;

public class CodonCount {
    private HashMap<String, Integer> codonCounts;

    public CodonCount() {
        codonCounts = new HashMap<String, Integer>();
    }

    private void buildCodonMap(int start, String dna) {
        codonCounts.clear();
        for (int i = start; i < dna.length(); i += 3) {
            try {
                if (codonCounts.containsKey(dna.substring(i, i + 3))) {
                    codonCounts.put(dna.substring(i, i + 3), codonCounts.get(dna.substring(i, i + 3)) + 1);
                } else {
                    codonCounts.put(dna.substring(i, i + 3), 1);
                }
            } catch (Exception e) {
                // do nothing
            }
        }
    }

    public void printCodonCounts(int start, int end) {
        buildCodonMap(0, "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC");
        int count = 0;
        for (String codon : codonCounts.keySet()) {
            if (codonCounts.get(codon) >= start && codonCounts.get(codon) <= end) {
                count++;
                System.out.println(codon + "\t" + codonCounts.get(codon));
            }
        }
        System.out.println();
        System.out.println(count);
    }
}