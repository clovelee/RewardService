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

public class AssetChaincodeManager {

	private static AssetChaincodeManager instance;
	
	private ChaincodeManager abericChaincodeManager;
	
	public static AssetChaincodeManager obtain() 
			throws CryptoException, 
			InvalidArgumentException, NoSuchAlgorithmException, 
			NoSuchProviderException, InvalidKeySpecException, 
			TransactionException, IOException {
		if (instance == null) {
			synchronized (AssetChaincodeManager.class) {
				if (instance == null) {
					instance = new AssetChaincodeManager();
				}
			}
		}
		return instance;
	}
	
	private AssetChaincodeManager() 
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
				.addPeer("peer1.org1.example.com", "peer1.org1.example.com", "grpc://192.168.0.49:7051", "grpc://192.168.0.49:7053", "http://192.168.0.49:7054")
				.setOrderers("example.com")
				.addOrderer("orderer.example.com", "grpc://192.168.0.19:7050")
				.setChaincode("mychannel", "mychannel", "github.com/hyperledger/fabric/aberic/chaincode/go/chaincode_example02", "1.0")
				.getChaincodeManager();
		return chaincodeManager;
	}
}
