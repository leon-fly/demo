package com.leon.demo.proxy.static_;

import com.leon.demo.proxy.BusinessComponent;
import com.leon.demo.proxy.impl.BusinessComponentImpl;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/9/25
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        BusinessComponentStaticProxy componentStaticProxy = new BusinessComponentStaticProxy(new BusinessComponentImpl());
        componentStaticProxy.work();
    }

    public static class BusinessComponentStaticProxy implements BusinessComponent {

        private BusinessComponent target;

        public BusinessComponentStaticProxy(){
            super();
        }

        public BusinessComponentStaticProxy(BusinessComponent proxyTarget){
            super();
            this.target = proxyTarget;
        }

        @Override
        public void work() {
            System.out.println("Proxy--工作开始时间>>>"+System.currentTimeMillis());
            target.work();
            System.out.println("Proxy--工作结束时间>>>"+System.currentTimeMillis());
        }
    }
}
