

public class TestResult {

        private String URL;
        private Long time;

        public TestResult(String Url, Long time ) {
            this.URL = Url;
            this.time = time;
        }
        public String getURL() {
            return URL;
        }

        public Long getTime() {
            return time;
        }
    }

