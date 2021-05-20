package fc.test1.oauth2.core.support.strategy;


public interface IStrategy<C> {

	/**
	 * 获得策略条件
	 *
	 * @param
	 * @return 用来注册的策略处理条件
	 */
	C getCondition();
}
