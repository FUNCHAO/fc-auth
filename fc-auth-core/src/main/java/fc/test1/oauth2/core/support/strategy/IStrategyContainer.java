package fc.test1.oauth2.core.support.strategy;

/**
 * 蔡锐  2015年10月18日
 *
 * @param <C> 条件类型
 * @param <S> 策略类型
 */
public interface IStrategyContainer<C, S extends IStrategy<C>> {
	/**
	 * 获得处理策略
	 *
	 * @param condition 策略条件
	 * @return 对应策略条件的策略
	 */
	S getStrategy(final C condition);
}
