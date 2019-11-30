public class TestResult {

        private String URL;
        private int time;

        public TestResult(String Url, int count ) {
            this.URL = URL;
            this.time = count;
        }
        public String getURL() {
            return URL;
        }

        public int getTime() {
            return time;
        }
    }
}
