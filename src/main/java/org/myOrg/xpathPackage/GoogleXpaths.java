package org.myorg.xpathPackage;

public class GoogleXpaths {
    public static final String firstResultXpath = "//.[@id=\"rso\"]/div[1]//.[@class=\"byrV5b\"]";
    public static final String disagreeGoogleXpath = "//.[@id=\"W0wltc\"]";
    public static final String searchFieldXpath = "//.[@id=\"APjFqb\"]";
    public static final String disagreeYoutubeXpath = "//./button[@aria-label=\"Reject the use of cookies and other data for the purposes described\"]";
    public static final String youtubeSearchFieldXpath = "//input[@id=\"search\"]";
    public static final String youtubeSearchFilterXpath = "//button[@aria-label=\"Search filters\"]";
    public static final String ytSearchButtonXpath = "//.[@id=\"search-icon-legacy\"]";
    public static final String ytSortByXpath(String sortName) {
        return "//.[@id=\"endpoint\"]//*[contains(text(),'" + sortName + "')]";
    }
    public static final String videosOnPageXpath = "//*[@id=\"contents\"]/ytd-video-renderer";
    public static final String ytVideoXpath(int index){
        return "//*[@id=\"contents\"]/ytd-video-renderer[" + index + "]//*[@id=\"channel-info\"]" +
                "//*[@class=\"style-scope ytd-channel-name\"]//a";
    }

}
