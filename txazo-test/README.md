<h2>
    <a id="user-content-txazo-test" class="anchor" href="#txazo-test" aria-hidden="true">
    <span class="octicon octicon-link"></span></a>
    txazo-test
</h2>
<ul>
    <li><a href="#user-content-txazo-test-suite">套件测试</a></li>
</ul>

<h3>
    <a id="user-content-txazo-test-suite" class="anchor" href="#txazo-test-suite" aria-hidden="true">
    <span class="octicon octicon-link"></span></a>
    套件测试
</h3>
<pre>
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

public class MyTest extends AbstractTest {

    @Test
    public void test() {
    }

}

import org.txazo.test.runner.SuiteTestRunner;
import org.txazo.test.runner.TestRunner;

public class RunnerTest {

    public static void main(String[] args) {
        TestRunner runner = new SuiteTestRunner();
        runner.run("org.txazo.test", true);
    }

}
</pre>