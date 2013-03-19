package sample.datanucleus_sample.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import org.datanucleus.api.jpa.annotations.Extension;
import org.datanucleus.api.jpa.annotations.Extensions;
import org.datanucleus.api.jpa.annotations.SurrogateVersion;

@Entity
@Extensions({
	@Extension(vendorName = "datanucleus", key = "hbase.columnFamily.meta.bloomFilter", value = "ROWKEY"),
	@Extension(vendorName = "datanucleus", key = "hbase.columnFamily.meta.inMemory", value = "true") })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name = "meta:firstName")
	private String firstName;

	@Column(name = "meta:lastName")
	private String lastName;

	@Column(name = "meta:birthDay")
	private Date birthDay;

	@Column(name = "meta:sex")
	private Integer sex;

	@Version
	private long version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
