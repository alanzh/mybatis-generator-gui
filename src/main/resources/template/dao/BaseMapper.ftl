${copyright}

package ${modulePackage}.dao;

import java.util.List;

import ${modulePackage}.utils.SearchCondition;

/**
 * @author ${authName}
 * @version ${.now?date}
 */

public interface BaseMapper<T> {

	int deleteByPrimaryKey(Long id);

	int insert(T entry);

	int insertSelective(T entry);

	T selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(T entry);

	int updateByPrimaryKey(T entry);

	List<T> search(SearchCondition<T> searchCondition);

	int searchCount(SearchCondition<T> searchCondition);

}