package utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScraperHelper {
    public static List<List<String>> scrapeLastTableInPage() {
        Element table = getLastTableInCurrentPage();
        Elements rows = getAllRows(table);

        List<List<String>> dataTableSkipHeader = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) {
            List<String> data = getAllDataByIndex(rows, i);
            dataTableSkipHeader.add(data);
        }

        return dataTableSkipHeader;
    }

    private static Elements getAllTables(Document doc) {
        return doc.select("table");
    }

    private static Elements getAllRows(Element table) {
        return table.select("tr");
    }

    private static List<String> getAllDataByIndex(Elements rows, int idx) {
        Elements data = rows.get(idx).select("td");
        return getAllData(data);
    }

    private static List<String> getAllData(Elements row) {
        return row.stream()
                .map(x -> x.text())
                .collect(Collectors.toList());
    }

    private static Element getLastTableInCurrentPage() {
        String htmlCurrentPage = DriverUtils.getPageSource();
        Document doc = Jsoup.parse(htmlCurrentPage);
        Elements AllTables = getAllTables(doc);
        return AllTables.get(AllTables.size() - 1);
    }
}
