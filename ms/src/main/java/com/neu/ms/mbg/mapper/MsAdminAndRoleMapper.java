package com.neu.ms.mbg.mapper;

import com.neu.ms.mbg.model.MsAdminAndRole;
import com.neu.ms.mbg.model.MsAdminAndRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsAdminAndRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    long countByExample(MsAdminAndRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int deleteByExample(MsAdminAndRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int insert(MsAdminAndRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int insertSelective(MsAdminAndRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    List<MsAdminAndRole> selectByExample(MsAdminAndRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    MsAdminAndRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int updateByExampleSelective(@Param("record") MsAdminAndRole record, @Param("example") MsAdminAndRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int updateByExample(@Param("record") MsAdminAndRole record, @Param("example") MsAdminAndRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int updateByPrimaryKeySelective(MsAdminAndRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ms_admin_and_role
     *
     * @mbg.generated Tue Mar 16 19:33:22 CST 2021
     */
    int updateByPrimaryKey(MsAdminAndRole record);
}