package org.qe.hawkular.util;

import java.util.List;

import org.testng.annotations.DataProvider;

public class HawkularDataProvider {

    @DataProvider(name = "browsersAndOs", parallel = true)
    public static Object[][] dataProviderTest() throws Exception {

        List<String> browsersList = BrowsersAndOs.readBrowsersAndOsFromFile();

        Object[][] dataProv;
        dataProv = new Object[browsersList.size()][3];

        int i = 0;
        for (; i++ < browsersList.size();) {
            dataProv[i - 1] = browsersList.get(i - 1).split(":");
        }
        return dataProv;
    }
}
