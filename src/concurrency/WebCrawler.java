package concurrency;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author arnab.ray
 * @created on 05/11/22
 */

interface HtmlParser {
    // Return a list of all urls from a webpage of given url.
    // This is a blocking call, that means it will do HTTP request and return when this request is finished.
    List<String> getUrls(String str);
}

public class WebCrawler {
    static class Crawler extends Thread {
        private final String startUrl;
        private final String hostname;
        private final HtmlParser htmlParser;
        public volatile List<String> res;

        public Crawler(String startUrl, String hostname, HtmlParser htmlParser) {
            this.startUrl = startUrl;
            this.hostname = hostname;
            this.htmlParser = htmlParser;
            this.res = new ArrayList<>();
        }

        @Override
        public void run() {
            String host = URI.create(startUrl).getHost();

            if (!host.equals(hostname) || res.contains(startUrl)) {
                return;
            }

            res.add(startUrl);
            List<Thread> threads = new ArrayList<>();
            for (String s : htmlParser.getUrls(startUrl)) {
                Crawler crawler = new Crawler(s, hostname, htmlParser);
                crawler.start();
                threads.add(crawler);
            }

            for (Thread t : threads) {
                joinThread(t);
            }
        }

        public static void joinThread(Thread thread) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String host = URI.create(startUrl).getHost();
        Crawler crawler = new Crawler(startUrl, host, htmlParser);
        crawler.res = new ArrayList<>();
        crawler.start();
        Crawler.joinThread(crawler);
        return crawler.res;
    }
}
