package sample.datanucleus_sample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.datanucleus.api.jpa.annotations.Extension;
import org.datanucleus.api.jpa.annotations.Extensions;
import org.datanucleus.api.jpa.annotations.SurrogateVersion;

@Entity
@SurrogateVersion
@Extensions({
	@Extension(vendorName = "datanucleus", key = "hbase.columnFamily.meta.bloomFilter", value = "ROWKEY"),
	@Extension(vendorName = "datanucleus", key = "hbase.columnFamily.meta.inMemory", value = "true") })
public class MyClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 798918514295302556L;

	@Id
	private long id;

	// column family data, name of attribute blob
	@Column(name = "data:blob")
	private String blob;

	// column family meta, name of attribute firstName
	@Column(name = "meta:firstName")
	private String firstName;

	// column family meta, name of attribute firstName
	@Column(name = "meta:lastName")
	private String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBlob() {
		return blob;
	}

	public void setBlob(String blob) {
		this.blob = blob;
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
}