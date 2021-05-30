/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.homework_13.e12;

import hr.fer.oop.homework_13.e01.PollingStation;
import hr.fer.oop.homework_13.e05.PollingResults;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Main {

    public static void main(String[] args) throws IOException, BiffException {

                       //save zip from url
//        String url = "https://www.izbori.hr/lokalni2021/rezultati/1/zip/ZUP_21.zip";
        String file = "ZUP_21.zip";
//        try ( InputStream is = new BufferedInputStream(new URL(url).openStream())) {
            //one line solution to copy Inputstream contents to file
//            Files.copy(is, Path.of(file), StandardCopyOption.REPLACE_EXISTING);

            //multi-line solution to copy Inputstream contents to file
//            try ( BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("ZUP_21.zip"))) {
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = is.read(buffer, 0, 1024)) != -1) {
//                    output.write(buffer, 0, bytesRead);
//                }
//            }
//        }

        //get workbook from zip
        try ( ZipFile zipFile = new ZipFile(file)) {
            //get the first entry in zip
            ZipEntry zipEntry = zipFile.stream().findFirst().get();
            
            //open the first entry in zip
            try ( InputStream is = zipFile.getInputStream(zipEntry)) {
                //open the workbook 
                Workbook workbook = Workbook.getWorkbook(is);
                
                //do something with the workbook
                //System.out.println(Arrays.toString(workbook.getSheetNames()));
                PollingResults pollingResults = new PollingResults(workbook);
//                System.out.println(pollingResults.getAssemblyResults());

                //print top-10 polling stations for a candidate
//                System.out.println("\nTop-10 polling stations for a candidate: ");
//                pollingResults.
//                        getMayorResults().
//                        entrySet().
//                        stream().
//                        map(entry -> new SimpleEntry<>(entry.getKey(), entry.getValue().get("ANKA MRAK-TARITAŠ"))).
//                        sorted(Comparator.comparing(Entry<PollingStation, Integer>::getValue).reversed()).
//                        limit(10).
//                        forEach(entry -> System.out.format("%nPollingStation{%d}=%d",
//                        entry.getKey().getId(), entry.getValue()));
                
                //print max percentages for a polling station
//                System.out.println("\nMax percentage for a candidate: ");
//                pollingResults.
//                        getMayorResults().
//                        entrySet().
//                        stream().
//                        flatMap(entry -> {
//                            //calculate number of votes for a polling station
//                            int sum = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
//                            return entry.getValue().entrySet().stream().map(candidateEntry -> new SimpleEntry<>(candidateEntry.getKey(), candidateEntry.getValue() / (double) sum));
//                        }).
//                        collect(Collectors.toMap(Entry::getKey, Entry::getValue, Double::max)).
//                        forEach((k, v) -> System.out.printf("%s %.2f%n", k, v));

//                //print mayor votes
//                Map<String, Integer> mayorVotes = getCandidateVotes(pollingResults.getMayorResults());
//                System.out.println("Mayor candidate votes: " + mayorVotes);

                //print sorted mayor votes
//                List<Entry<String, Integer>> sortedMayorVotes = mayorVotes.
//                        entrySet().
//                        stream().
//                        sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed()).
//                        collect(Collectors.toList());
//                System.out.println("\nSorted mayor candidate votes: " + sortedMayorVotes);
                
                //print mayor percentages                
//                System.out.println("\nMayor candidate percentages:");
//                double sum = mayorVotes.
//                        entrySet().
//                        stream().
//                        mapToInt(Entry::getValue).
//                        sum();
//
//                mayorVotes.
//                        entrySet().
//                        stream().
//                        map(entry -> new SimpleEntry<>(entry.getKey(), 100 * entry.getValue() / (double) sum)).
//                        forEach(e -> System.out.format("%s=%.2f%%%n", e.getKey(), e.getValue()));
                
                //print polling station titles sorted by assembly votes
                List<Entry<String, Integer>> titlesSortedPerVotes = getTitlesSortedPerVotes(pollingResults.getAssemblyResults());
                System.out.println("\nSorted votes per polling station title: " + titlesSortedPerVotes);
            }
        }
    }

    private static Map<String, Integer> getCandidateVotes(Map<PollingStation, Map<String, Integer>> results) {
        Map<String, Integer> candidateVotes = new HashMap<>();

        results.values().stream().forEach(map -> map.entrySet().stream().forEach(entry
                -> candidateVotes.merge(entry.getKey(), entry.getValue(), (oldVotes, votes) -> oldVotes + votes)));

        return candidateVotes;
    }

//    private static List<Entry<String, Integer>> getTitlesSortedPerVotes(Map<PollingStation, Map<String, Integer>> results) {
//        Map<String, Integer> titleVotes = new TreeMap<>();
//
//        results.entrySet().forEach(entry -> titleVotes.compute(entry.getKey().getTitle(), (title, votes) -> {
//            int sum = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
//            return votes == null ? sum : votes + sum;
//        }));
//
//        return titleVotes.entrySet().stream().sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed()).collect(Collectors.toList());
//    }

    private static List<Entry<String, Integer>> getTitlesSortedPerVotes(Map<PollingStation, Map<String, Integer>> results) {
        return results.
                entrySet().
                stream().
                map(entry -> new SimpleEntry<>(entry.getKey().getTitle(), entry.getValue().values().stream().mapToInt(Integer::intValue).sum())).
                collect(Collectors.toMap(Entry::getKey, Entry::getValue, Integer::sum)).
                entrySet().
                stream().
                sorted(Comparator.comparing(Entry<String, Integer>::getValue).reversed()).
                collect(Collectors.toList());
    }
}
