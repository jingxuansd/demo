package com.jingxuan.demo;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.SqlScriptSource;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.config.SchemaConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.distribution.Version.v5_7_17;

/**
 * @Author: Xuan Jing
 * @Date: 2020/6/25 11:38 PM
 */
@Ignore
@ActiveProfiles("test")
@MybatisTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BaseMapperTest {
    private static EmbeddedMysql embeddedMysql;

    private static SchemaConfig schemaConfig;

    private static String dbSchemaName = "test";

    private static int dbPort = 3307;

    private static String initScript = "db/init/init.sql";

    @BeforeClass
    public static void start() {
        if (embeddedMysql == null) {
            MysqldConfig config = MysqldConfig.aMysqldConfig(v5_7_17)
                    .withPort(dbPort)
                    .withTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")))
                    .withUser("test", "test")
                    .build();

            schemaConfig = SchemaConfig.aSchemaConfig(dbSchemaName)
                    .withScripts(classPathScript(initScript))
                    .build();

            embeddedMysql = EmbeddedMysql.anEmbeddedMysql(config)
                    .addSchema(schemaConfig)
                    .start();
        }
    }

    public void executeScriptsWithReLoadSchema(String... dbPathScript) {
        embeddedMysql.reloadSchema(schemaConfig);
        executeScripts(dbPathScript);
    }


    private void executeScripts(String... dbPathScript) {
        List<SqlScriptSource> scripts = new LinkedList<>();
        for (String dataFile : dbPathScript) {
            scripts.add(classPathScript(dataFile));
        }
        embeddedMysql.executeScripts(dbSchemaName, scripts);
    }

    public void clearDBData() {
        embeddedMysql.dropSchema(schemaConfig);
    }

    @AfterClass
    public static void stop() {
        if (embeddedMysql != null) {
            embeddedMysql.stop();
        }
    }
}
