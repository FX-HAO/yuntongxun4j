package yuntongxun4j;

import yuntongxun4j.conf.Configuration;
import yuntongxun4j.conf.PropertyConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class YunTongXunFactory {
    private final Configuration conf;
    private final YunTongXun instance;

    public Configuration getConf() {
        return conf;
    }

    static {
        YunTongXunFactory.setDefaultProperties();
    }

    private static void setDefaultProperties() {
        File f = new File(System.getProperty("user.home"), "yuntongxun4j.properties");
        if (f.isFile()) {
            Properties p = new Properties();
            try {
                p.load(new FileInputStream(f));
            }
            catch (IOException e) {
            }
            System.getProperties().putAll(p);
        }
    }

    public YunTongXunFactory() {
        this(System.getProperties());
    }

    public YunTongXunFactory(Properties props) {
        PropertyConfiguration conf = new PropertyConfiguration();
        conf.setProperties(props);
        this.conf = conf;
        this.instance = new YunTongXunImpl(conf);
    }

    /**
     * Returns a instance associated with the configuration bound to this factory.
     *
     * @return default singleton instance
     */
    public YunTongXun getInstance() {
        return instance;
    }
}
