package com.chinauicom.research.fabric.sdk.manager;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import com.chinauicom.research.fabric.sdk.aberic.ChaincodeManager;
import com.chinauicom.research.fabric.sdk.aberic.Fabric;
import com.chinauicom.research.fabric.sdk.aberic.FabricConfig;

import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.TransactionException;

public class PointsChaincodeManager {

	private static PointsChaincodeManager instance;
	
	private ChaincodeManager abericChaincodeManager;
	
	public static PointsChaincodeManager obtain() 
			throws CryptoException, 
			InvalidArgumentException, NoSuchAlgorithmException, 
			NoSuchProviderException, InvalidKeySpecException, 
			TransactionException, IOException {
		if (instance == null) {
			synchronized (PointsChaincodeManager.class) {
				if (instance == null) {
					instance = new PointsChaincodeManager();
				}
			}
		}
		return instance;
	}
	
	private PointsChaincodeManager() 
			throws CryptoException, 
			InvalidArgumentException, NoSuchAlgorithmException, 
			NoSuchProviderException, InvalidKeySpecException, 
			TransactionException, IOException {
		abericChaincodeManager = obtainDemoChaincodeManager();
	}
	
	public ChaincodeManager getDemoChaincodeManager() {
		return abericChaincodeManager;
	}
	
	private ChaincodeManager obtainDemoChaincodeManager() 
			throws CryptoException, 
			InvalidArgumentException, NoSuchAlgorithmException, 
			NoSuchProviderException, InvalidKeySpecException, 
			TransactionException, IOException {
		Fabric fabric = new Fabric();
		ChaincodeManager chaincodeManager = fabric
				.setUser("Admin")
				.setChannleArtifactsPath(new FabricConfig().getChannelArtifactsPath())
				.setCryptoConfigPath(new FabricConfig().getCryptoConfigPath())
				.setPeers("Org1", "Org1MSP", "org1.example.com")
				.addPeer("peer0.org1.example.com", "peer0.org1.example.com", "grpc://192.168.0.20:7051", "grpc://192.168.0.20:7053", "http://192.168.0.20:7054")
				.setOrderers("example.com")
				.addOrderer("orderer.example.com", "grpc://192.168.0.19:7050")
				.setChaincode("mychannel", "mcc", "github.com/hyperledger/fabric/aberic/chaincode/go/chaincode_points", "1.0")
				.getChaincodeManager();
		return chaincodeManager;
	}
}
