/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.homework_13.e04;

import hr.fer.oop.homework_13.e01.PollingStation;
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

    public PollingResults(Workbook workbook) {
        //load mayor result
        this.assemblyResults = fillResults(workbook.getSheet(0));

        //load assembly results
        this.mayorResults = fillResults(workbook.getSheet(1));
    }

    private static Map<PollingStation, Map<String, Integer>> fillResults(Sheet sheet) {
        return null;
    }

    public Map<PollingStation, Map<String, Integer>> getAssemblyResults() {
        return assemblyResults;
    }

    public Map<PollingStation, Map<String, Integer>> getMayorResults() {
        return mayorResults;
    }
}
