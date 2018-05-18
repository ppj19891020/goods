import com.clubfactory.core.mybatis.PaginationPlugin;
import org.mybatis.generator.api.ShellRunner;

/**
 * 描述:
 *   自动生成代码工具
 * @author pangpeijie
 * @create 2018-05-18 15:38
 */
public class AutoGeneratorRunner {

    public static void main(String[] args) {
        String config = PaginationPlugin.class.getClassLoader().getResource("generatorConfig.xml").getFile();
        String[] arg = { "-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
    }

}
