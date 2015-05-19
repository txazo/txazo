<h2>
    <a id="user-content-txazo-test" class="anchor" href="#txazo-test" aria-hidden="true">
    <span class="octicon octicon-link"></span></a>
    txazo-test
</h2>
<ul>
    <li><a href="#user-content-txazo-test-1">1. 集成Junit4单元测试</a></li>
    <li><a href="#user-content-txazo-test-2">2. 集成Junit4套件测试</a></li>
</ul>

<h3>
    <a id="user-content-txazo-test-1" class="anchor" href="#txazo-test-v1.0" aria-hidden="true">
    <span class="octicon octicon-link"></span></a>
    集成Junit4单元测试
</h3>
<pre>
import org.junit.Test;
import org.txazo.test.AbstractTest;

public class MyTest extends AbstractTest {

    @Test
    public void test() {
    }

}
</pre>

<h3>
    <a id="user-content-txazo-test-2" class="anchor" href="#txazo-test-v1.0" aria-hidden="true">
    <span class="octicon octicon-link"></span></a>
    集成Junit4套件测试
</h3>
<pre>
import org.junit.Test;
import org.txazo.test.suite.SuiteTest;

public class MyTest extends SuiteTest {

    @Test
    public void test() {
    }

}

import org.txazo.test.suite.SuiteRunTest;

public class SuiteRunTestTest {

    public static void main(String[] args) {
        new SuiteRunTest("org.txazo.test").run();
    }

}
</pre>