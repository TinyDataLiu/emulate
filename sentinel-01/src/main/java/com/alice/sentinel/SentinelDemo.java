package com.alice.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Sentinel 限流
 */
@Slf4j
public class SentinelDemo {

    /**
     * 初始化限流规则
     */
    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    public static void main(String[] args) throws InterruptedException {
        initFlowRules();
        while (true) {
            try (Entry entry = SphU.entry("HelloWorld")) {
                log.info("{}", "被保护的逻辑======================================");
            } catch (BlockException e) {
                log.info("{}", "限流处理");
            }
            TimeUnit.MILLISECONDS.sleep(20);
        }
    }

}
