<h2>
    <a id="user-content-txazo-java-security" class="anchor" href="#txazo-java-security" aria-hidden="true">
    <span class="octicon octicon-link"></span></a>
    txazo-java-security
</h2>

<h3>
    <a id="user-content-txazo-test-suite" class="anchor" href="#txazo-test-suite" aria-hidden="true">
    <span class="octicon octicon-link"></span></a>
    套件测试
</h3>
<pre>
import org.txazo.test.SuiteTest;
import org.txazo.test.assertion.Assert;
import org.txazo.test.annotation.Test;

public class MyTest extends SuiteTest {

    @Test
    public void test() {
        Assert.assertTrue(true);
    }

}
</pre>
<pre>
import org.txazo.test.runner.SuiteTestRunner;
import org.txazo.test.runner.TestRunner;

public class RunnerTest {

    public static void main(String[] args) {
        TestRunner runner = new SuiteTestRunner();
        runner.run(MyTest.class);
    }

}
</pre>
