/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.homework_13.e05;

import hr.fer.oop.homework_13.e01.PollingStation;
import java.util.HashMap;
import java.util.Map;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class PollingResults {

    private Map<PollingStation, Map<String, Integer>> mayorResults;
    private Map<PollingStation, Map<String, Integer>> assemblyResults;

    private static final int START_CANDIDATES_INDEX = 13;
    private static final int END_POLLING_STATION_INDEX = 7;

    public PollingResults(Workbook workbook) {
        //load mayor result
        this.assemblyResults = fillResults(workbook.getSheet(0));

        //load assembly results
        this.mayorResults = fillResults(workbook.getSheet(1));
    }

    public Map<PollingStation, Map<String, Integer>> getAssemblyResults() {
        return assemblyResults;
    }

    public Map<PollingStation, Map<String, Integer>> getMayorResults() {
        return mayorResults;
    }

    private static Map<PollingStation, Map<String, Integer>> fillResults(Sheet sheet) {
        Map<PollingStation, Map<String, Integer>> results = new HashMap<>();

        int rows = sheet.getRows();
        int columns = sheet.getColumns();

        //extract candidates from the first row
        String[] candidates = new String[columns - START_CANDIDATES_INDEX];
        for (int j = START_CANDIDATES_INDEX; j < columns; j++) {
            candidates[j - START_CANDIDATES_INDEX] = sheet.getCell(j, 0).getContents();
        }

        for (int i = 1; i < rows; i++) {
            //extract polling station data
            String[] pollingStationData = new String[END_POLLING_STATION_INDEX + 1];
            for (int j = 0; j <= END_POLLING_STATION_INDEX; j++) {
                pollingStationData[j] = sheet.getCell(j, i).getContents();
            }
            PollingStation pollingStation = new PollingStation(Integer.parseInt(pollingStationData[0]), pollingStationData[1],
                    pollingStationData[2], pollingStationData[3], Integer.parseInt(pollingStationData[4]),
                    pollingStationData[5], pollingStationData[6], pollingStationData[7]);

            //extract candidates and votes
            for (int j = START_CANDIDATES_INDEX; j < columns; j++) {
                Map<String, Integer> pollingStationResults = results.getOrDefault(pollingStation, new HashMap<>());
                pollingStationResults.put(candidates[j - START_CANDIDATES_INDEX], Integer.parseInt(sheet.getCell(j, i).getContents()));
                results.put(pollingStation, pollingStationResults);
            }
        }

        return results;
    }
}
