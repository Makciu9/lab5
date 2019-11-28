public class TestResult {

        private String URL;
        private int count;

        public TestResult(String Url, int count ) {
            this.URL = URL;
            this.count = count;
        }
        public String getURL() {
            return URL;
        }

        public int getCount() {
            return count;
        }
    }
}
