package kr.co.bunnyfoot.bunnyfoot.googlaanalytics;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.AnalyticsReportingScopes;
import com.google.api.services.analyticsreporting.v4.model.DateRange;
import com.google.api.services.analyticsreporting.v4.model.GetReportsRequest;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;

@Component
public class GoogleAnalyticsReporting {
  private final String APPLICATION_NAME = "GoogleAnalyticsReporting";
  private final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
  private final String VIEW_ID = "240306840";
  private AnalyticsReporting analyticsReportingService;
  
  private GoogleAnalyticsReporting() {
    try {
      this.analyticsReportingService = initializeAnalyticsReporting();
    } catch (GeneralSecurityException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public String getPageView() {
    GetReportsResponse response;
    String pageView = "";
    try {
      response = getReport();
      pageView = response.getReports().get(0).getData().getTotals().get(0).getValues().get(0);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return pageView;
  }

  /**
   * Initializes an Analytics Reporting API V4 service object.
   *
   * @return An authorized Analytics Reporting API V4 service object.
   * @throws IOException
   * @throws GeneralSecurityException
   */
  private AnalyticsReporting initializeAnalyticsReporting() throws GeneralSecurityException, IOException {
    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    GoogleCredential credential = GoogleCredential
        .fromStream(new ClassPathResource("bunnyfoot.json").getInputStream())
        .createScoped(AnalyticsReportingScopes.all());
    // Construct the Analytics Reporting service object.
    return new AnalyticsReporting.Builder(httpTransport, JSON_FACTORY, credential)
        .setApplicationName(APPLICATION_NAME).build();
  }

  /**
   * Queries the Analytics Reporting API V4.
   *
   * @param service An authorized Analytics Reporting API V4 service object.
   * @return GetReportResponse The Analytics Reporting API V4 response.
   * @throws IOException
   */
  private GetReportsResponse getReport() throws IOException {
    // Create the DateRange object.
    DateRange dateRange = new DateRange();
    dateRange.setStartDate("2021-06-05");
    dateRange.setEndDate("today");

    // Create the Metrics object.
    Metric sessions = new Metric()
        .setExpression("ga:sessions");

    // Create the ReportRequest object.
    ReportRequest request = new ReportRequest()
        .setViewId(VIEW_ID)
        .setDateRanges(Arrays.asList(dateRange))
        .setMetrics(Arrays.asList(sessions));

    ArrayList<ReportRequest> requests = new ArrayList<ReportRequest>();
    requests.add(request);

    // Create the GetReportsRequest object.
    GetReportsRequest getReport = new GetReportsRequest()
        .setReportRequests(requests);

    // Call the batchGet method.
    GetReportsResponse response = analyticsReportingService.reports().batchGet(getReport).execute();

    // Return the response.
    return response;
  }
}