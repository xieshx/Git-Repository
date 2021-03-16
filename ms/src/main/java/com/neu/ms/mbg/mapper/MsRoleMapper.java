package com.neu.ms.mbg.mapper;

import com.neu.ms.mbg.model.MsRole;
import com.neu.ms.mbg.model.MsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    long countByExample(MsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int deleteByExample(MsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int insert(MsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int insertSelective(MsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    List<MsRole> selectByExample(MsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    MsRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int updateByExampleSelective(@Param("record") MsRole record, @Param("example") MsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int updateByExample(@Param("record") MsRole record, @Param("example") MsRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int updateByPrimaryKeySelective(MsRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int updateByPrimaryKey(MsRole record);
}