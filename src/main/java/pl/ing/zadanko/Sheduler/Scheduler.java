package pl.ing.zadanko.Sheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.ing.zadanko.Services.ReportService;
import pl.ing.zadanko.Services.CsvParser;

@Component
public class Scheduler {
    CsvParser csvParser;

    ReportService reportService;

    @Autowired
    Scheduler(CsvParser csvParser, ReportService reportService) {
        this.csvParser = csvParser;
        this.reportService = reportService;
    }


    @Scheduled(cron = "0 */10 * * * *")
    public void parseCsvFileEvry10Minute() {
        csvParser.parse();
    }

    @Scheduled(cron = "0 0 22 * * *")
    public void daylyReport() {
        reportService.makeDayliReport();
    }
}